package pl.udu.uwr.pum.galleryapp.fragments

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import pl.udu.uwr.pum.galleryapp.dataProvider.DataProvider
import pl.udu.uwr.pum.galleryapp.R
import pl.udu.uwr.pum.galleryapp.databinding.FragmentAddPictureBinding
import pl.udu.uwr.pum.galleryapp.db.DBHandler
import pl.udu.uwr.pum.galleryapp.model.PictureModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*


class AddPictureFragment : Fragment(){

    private lateinit var binding: FragmentAddPictureBinding
    private lateinit var pictureAbsolutePath: Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCamera.setOnClickListener {
            openCamera()
        }

        binding.buttonSavePicture.setOnClickListener {
            if (checkForErrors())
                Toast.makeText(context, getString(R.string.error_imageView), Toast.LENGTH_LONG).show()
            else{
                val item = PictureModel(
                    binding.editTextTitle.text.toString(),
                    pictureAbsolutePath.toString()
                )

                val dbHandler = DBHandler(requireContext())
                val addItemResult = dbHandler.addToGallery(item)

                if(addItemResult > 0)
                    Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val resultLauncherCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.imageViewPicture.setImageBitmap(imageBitmap)
            pictureAbsolutePath = saveImage(imageBitmap)
        }
    }

    private val requestCameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it){
            launchCamera()
        }
    }

    private fun showMessageOKCancel(message: String) {
        AlertDialog.Builder(requireContext())
            .setMessage(message)
            .setPositiveButton("OK") { dialogInterface: DialogInterface, _: Int ->
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                dialogInterface.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }

    private fun openCamera(){
        when {ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED -> {
            launchCamera()
        }
            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.CAMERA) -> {
                showMessageOKCancel(getString(R.string.rationale_camera))
            }
            else -> {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun launchCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncherCamera.launch(intent)
    }

    private fun saveImage(bitmap: Bitmap): Uri {
        var file = requireContext().getDir("myGalleryKotlin", Context.MODE_PRIVATE)
        file = File(file, "${UUID.randomUUID()}.jpg")

        try {
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return Uri.parse(file.absolutePath)
    }

    private fun checkForErrors(): Boolean{
        if (binding.editTextTitle.text.isEmpty())
            return true
        if (!this::pictureAbsolutePath.isInitialized)
            return true
        return false
    }
}