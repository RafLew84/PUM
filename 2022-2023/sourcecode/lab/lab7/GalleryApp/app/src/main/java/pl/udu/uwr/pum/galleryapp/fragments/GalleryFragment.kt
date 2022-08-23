package pl.udu.uwr.pum.galleryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.galleryapp.R
import pl.udu.uwr.pum.galleryapp.adapter.GalleryAdapter
import pl.udu.uwr.pum.galleryapp.dataProvider.DataProvider
import pl.udu.uwr.pum.galleryapp.databinding.FragmentAddPictureBinding
import pl.udu.uwr.pum.galleryapp.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = GalleryAdapter(DataProvider.dummyData)
        }
    }
}