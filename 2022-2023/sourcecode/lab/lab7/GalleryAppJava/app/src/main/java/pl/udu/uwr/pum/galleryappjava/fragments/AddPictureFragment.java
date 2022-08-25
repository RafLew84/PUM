package pl.udu.uwr.pum.galleryappjava.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import pl.udu.uwr.pum.galleryappjava.R;
import pl.udu.uwr.pum.galleryappjava.databinding.FragmentAddPictureBinding;
import pl.udu.uwr.pum.galleryappjava.db.DBHandler;
import pl.udu.uwr.pum.galleryappjava.model.PictureModel;

public class AddPictureFragment extends Fragment {

    private FragmentAddPictureBinding binding;
    private Uri pictureAbsolutePath;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddPictureBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCamera.setOnClickListener(v -> {
            openCamera();
        });

        binding.buttonSavePicture.setOnClickListener(v -> {
            if (checkForErrors())
                Toast.makeText(getContext(), getString(R.string.error_imageView), Toast.LENGTH_LONG).show();
            else {
                PictureModel item = new PictureModel(
                        binding.editTextTitle.getText().toString(),
                        pictureAbsolutePath.toString()
                );

                DBHandler dbHandler = new DBHandler(requireContext());
                long addItemResult = dbHandler.addToGallery(item);

                if(addItemResult > 0)
                    Toast.makeText(getContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ActivityResultLauncher<String> requestCameraPermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    launchCamera();
                }
            });

    ActivityResultLauncher<Intent> resultLauncherCamera = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Bitmap imageBitmap;
                    if (data != null) {
                        imageBitmap = (Bitmap) data.getExtras().get("data");
                        binding.imageViewPicture.setImageBitmap(imageBitmap);
                        pictureAbsolutePath = saveImage(imageBitmap);
                    }
                }
            });

    private void showMessageOKCancel(String message) {
        new AlertDialog.Builder(requireContext())
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> {
                    requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA);
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void launchCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        resultLauncherCamera.launch(intent);
    }

    private void openCamera(){
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED )
            launchCamera();
        else if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.CAMERA))
            showMessageOKCancel(getString(R.string.rationale_camera));
        else
            requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA);
    }

    private Uri saveImage(Bitmap bitmap) {
        File file = requireContext().getDir("myGalleryJava", Context.MODE_PRIVATE);
        file = new File(file, UUID.randomUUID().toString() + "jpg");

        try {
            OutputStream stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Uri.parse(file.getAbsolutePath());
    }

    private boolean checkForErrors(){
        if (binding.editTextTitle.getText().toString().isEmpty())
            return true;
        return pictureAbsolutePath == null;
    }
}