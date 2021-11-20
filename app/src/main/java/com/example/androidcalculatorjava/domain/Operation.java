package com.example.androidcalculatorjava.domain;

import androidx.annotation.NonNull;

public enum Operation {

    EMPTY {
        @NonNull
        @Override
        public String toString() {
            return "";
        }
    },
    PLUS {
        @NonNull
        @Override
        public String toString() {
            return "+";
        }
    },
    DEDUCT {
        @NonNull
        @Override
        public String toString() {
            return "-";
        }
    },
    DIVISION {
        @NonNull
        @Override
        public String toString() {
            return "÷";
        }
    },
    MULTIPLICATION {
        @NonNull
        @Override
        public String toString() {
            return "x";
        }
    }
}
