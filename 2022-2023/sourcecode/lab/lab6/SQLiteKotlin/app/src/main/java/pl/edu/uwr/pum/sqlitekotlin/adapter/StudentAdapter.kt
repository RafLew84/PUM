package pl.edu.uwr.pum.sqlitekotlin.adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.sqlitekotlin.databinding.DialogUpdateBinding
import pl.edu.uwr.pum.sqlitekotlin.databinding.ItemRowBinding
import pl.edu.uwr.pum.sqlitekotlin.db.DBHandler
import pl.edu.uwr.pum.sqlitekotlin.model.Student

class StudentAdapter(private val dbHandler: DBHandler, private val context: Context) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: ItemRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Student) {
            itemBinding.textViewName.text = item.name
            itemBinding.textViewIndex.text = item.index.toString()
            itemBinding.textViewId.text = item.id.toString()

            itemBinding.imageViewDelete.setOnClickListener {
                dbHandler.deleteStudent(item)
                notifyItemRemoved(item.id - 1)
            }

            itemBinding.imageViewEdit.setOnClickListener {setupDialog(item) }
        }

        private fun setupDialog(item: Student){
            val dialog = Dialog(context)
            val dialogBinding = DialogUpdateBinding.inflate(LayoutInflater.from(context))
            dialog.apply {
                setCancelable(false)
                setContentView(dialogBinding.root)
            }

            dialogBinding.apply {
                editTextIndexUpdate.setText(item.index.toString())
                editTextNameUpdate.setText(item.name)
                buttonUpdate.setOnClickListener {
                    updateDialog(dialogBinding, item, dialog)
                }

                buttonCancel.setOnClickListener { dialog.dismiss() }
            }
            dialog.show()
        }

        private fun updateDialog(
            dialogBinding: DialogUpdateBinding,
            item: Student,
            dialog: Dialog
        ) {
            val updateName = dialogBinding.editTextNameUpdate.text.toString()
            val updateIndex = dialogBinding.editTextIndexUpdate.text.toString()

            if (updateName.isNotEmpty() && updateIndex.isNotEmpty()) {
                dbHandler.updateStudent(item.id, updateName, updateIndex.toInt())
                notifyItemChanged(item.id - 1)
                dialog.dismiss()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = ItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dbHandler.getStudents()[position]
        holder.bind(item)
    }

    override fun getItemCount() = dbHandler.getStudents().size

}