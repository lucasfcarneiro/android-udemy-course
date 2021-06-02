package com.lucasfagundes.androidudemycourse.feature.task_list

class Task {

    //private var id: Int
    private lateinit var name: String
    private var id: Int = 0

    fun setNameTask(name: String) {
        this.name = name
    }

    fun getNameTask(): String {
        return this.name
    }

    fun setId(id: Int) {
        this.id = id
    }


//
//    fun Long getId()
//    {
//        return id;
//    }
//
//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//
//    public String getNomeTarefa()
//    {
//        return nomeTarefa;
//    }
//
//    public void setNomeTarefa(String nomeTarefa)
//    {
//        this.nomeTarefa = nomeTarefa;
//    }
}