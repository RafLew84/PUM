package pl.edu.uwr.pum.pumapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import pl.edu.uwr.pum.pumapp.R
import pl.edu.uwr.pum.pumapp.data.DataProvider
import pl.edu.uwr.pum.pumapp.data.Module
import java.lang.IllegalArgumentException
import kotlin.properties.Delegates

class ModuleFragment : Fragment() {
    
    private val module by lazy {
        val moduleId = arguments?.getInt("moduleId")?:
            throw IllegalArgumentException("moduleId doesn't exist")
        DataProvider.modules[moduleId]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity: AppCompatActivity = activity as AppCompatActivity
        activity.supportActionBar?.title = module.name
        return inflater.inflate(R.layout.fragment_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.lectureButton).apply { 
            text = "Wykład:\n${module.lecture.name}"
            setOnClickListener {
                findNavController().navigate(ModuleFragmentDirections.actionModuleFragmentToLectureFragment(
                    moduleId = module.id
                ))
            }
        }
        
        view.findViewById<Button>(R.id.labButton).apply { 
            text = "Laboratorium:\n${module.lab.name}"
            setOnClickListener {
                findNavController().navigate(ModuleFragmentDirections.actionModuleFragmentToLabListFragment(
                    moduleId = module.id
                ))
            }
        }
        
        view.findViewById<Button>(R.id.appButton).apply { 
            text = requireContext().getString(R.string.aplications)
            setOnClickListener {
                findNavController().navigate(ModuleFragmentDirections.actionModuleFragmentToAppListFragment(
                    moduleId = module.id
                ))
            }
        }
    }
}