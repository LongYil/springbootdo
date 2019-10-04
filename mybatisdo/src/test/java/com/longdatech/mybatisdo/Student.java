package com.longdatech.mybatisdo;

public class Student{
        private Integer id;
        private String name;

        public Student() {
        }

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }