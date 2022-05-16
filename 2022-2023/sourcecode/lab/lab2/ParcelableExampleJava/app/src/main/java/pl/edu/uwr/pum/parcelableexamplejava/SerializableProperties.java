package pl.edu.uwr.pum.parcelableexamplejava;

import java.io.Serializable;

public class SerializableProperties implements Serializable {
        private int a;
        private int b;
        private String c;

        public SerializableProperties(int a, int b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
}
