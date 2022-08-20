package pl.udu.uwr.pum.taskyjava.model;

import androidx.annotation.Nullable;

import java.util.Objects;

public class TaskRow {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_TASK = 1;

    private final int rowType;

    public TaskRow(int rowType){
        this.rowType = rowType;
    }

    public int getRowType() {
        return rowType;
    }

    public static class Task extends TaskRow{
        private final String name;

        public Task(String name){
            super(TaskRow.TYPE_TASK);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return name.equals(task.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static class Header extends TaskRow{
        private final String name;
        private boolean isExpanded = true;

        public Header(String name){
            super(TaskRow.TYPE_HEADER);
            this.name = name;
        }

        public Header(String name, boolean isExpanded){
            this(name);
            this.isExpanded = isExpanded;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Header header = (Header) o;
            return name.equals(header.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public String getName() {
            return name;
        }

        public boolean isExpanded() {
            return isExpanded;
        }

        public void setExpanded(boolean expanded) {
            isExpanded = expanded;
        }
    }
}
