package pl.udu.uwr.pum.carsyappkotlin.fragments

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.carsyappkotlin.R
import pl.udu.uwr.pum.carsyappkotlin.adapters.TimeLineAdapter
import pl.udu.uwr.pum.carsyappkotlin.data.Cost
import pl.udu.uwr.pum.carsyappkotlin.data.DataProvider

class TimeLineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.timeLineRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TimeLineAdapter(context, DataProvider.cars[0].costs)
        }
        view.findViewById<Spinner>(R.id.cars_spinner).apply {
            adapter = ArrayAdapter(context, R.layout.spinner_layout, DataProvider.cars.map { it.name })
                .apply { setDropDownViewResource(R.layout.spinner_dropdown_layout) }
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?,
                                            view: View?, position: Int,
                                            id: Long) {
                    recycler.swapAdapter(TimeLineAdapter(context, DataProvider.cars[position].costs), true)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }
}