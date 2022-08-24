package pl.udu.uwr.pum.galleryappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.udu.uwr.pum.galleryappjava.R;
import pl.udu.uwr.pum.galleryappjava.adapter.GalleryAdapter;
import pl.udu.uwr.pum.galleryappjava.databinding.FragmentAddPictureBinding;
import pl.udu.uwr.pum.galleryappjava.databinding.FragmentGalleryBinding;
import pl.udu.uwr.pum.galleryappjava.db.DBHandler;


public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DBHandler dbHandler = new DBHandler(requireContext());


        binding.recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recycler.setAdapter(new GalleryAdapter(dbHandler.getAllItems()));

    }
}