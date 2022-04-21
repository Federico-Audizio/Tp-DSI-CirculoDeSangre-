package co.company


object Main {
    @JvmStatic

    fun main(args: Array<String>){

        val gestor = Gestor()

        do {

            println()
            println("----------------------------------------------------")
            println("Para registar un nuevo asociado ingrese            1")
            println("Para registar una donación ingrese                 2")
            println("Para ver el listado de donantes                    3")
            println("Para ver la lista de asociados ingrese             4")
            println("Para salir ingrese                                 0")
            println("----------------------------------------------------")

            val x = readLine()!!.toInt()

            when (x) {
                1 -> {
                    gestor.agregaeAsociado()
                }
                2 -> {
                    println("Ingrece el DNI del donante: ")
                    val donador = readLine()!!.toLong()
                    gestor.donaciones(donador)
                }
                3 -> {
                    val donacion = Donación()
                    donacion.donacion(gestor)

                }
                4 ->{
                    println("Asociados: ")
                    for(asociado in gestor.asociados) {
                        println("${asociado.Nombre} ${asociado.Apellido}, estado: ${asociado.Estado}")
                    }
                }
            }
        }while (x != 0)



    }
}