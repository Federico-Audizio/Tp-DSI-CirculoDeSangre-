package co.company


object Main {

    @JvmStatic

    fun main(args: Array<String>){

        var importeActivo = 500F
        var importePasivo = 200F
        val gestor = Gestor()
        val pago = pago()


        do {

            println()
            println("----------------------------------------------------")
            println("Asociado:                                           ")
            println("Para registar un nuevo asociado ingrese            1")
            println("Para registar una donación ingrese                 2")
            println("Para ver la lista de asociados ingrese             3")
            println("Banco de sangre:                                    ")
            println("Para ver el listado de donantes                    4")
            println("Cuota:                                              ")
            println("para Generar cuotas del mes                        5")
            println("Para cambiar el valor de la cuota                  6")
            println("Para realizar pago de la cuota                     7")
            println("Para ver listado de cuotas                         8")
            println("Para ver generar el  listado de cuotas             9")
            println("")
            println("Para salir ingrese                                 0")
            println("----------------------------------------------------")
            print("-->")

            val x = readLine()!!.toInt()

            when (x) {
                1 -> {
                    gestor.agregaeAsociado()
                }
                2 -> {
                    print("Ingrece el DNI del donante: ")
                    val donador = readLine()!!.toLong()
                    gestor.donaciones(donador)
                }
                3 -> {
                    println("Asociados: ")
                    for(asociado in gestor.asociados) {
                        println("${asociado.Nombre} ${asociado.Apellido}, estado: ${asociado.Estado}")
                    }
                }
                4 ->{
                    val donacion = Donación()
                    donacion.donacion(gestor)
                }
                5 ->{
                    println("Generar Cuota: ")
                    for(asociado in gestor.asociados) {
                        pago.GenerarCuota(asociado,importeActivo, importePasivo)
                    }
                }
                6 ->{
                    print("Ingrece el valor del importe del asociado activo")
                    importeActivo = readLine()!!.toFloat()
                    print("Ingrece el valor del importe del asociado pasivo")
                    importePasivo = readLine()!!.toFloat()
                }

                7->{
                    print("Ingrese el DNI del asociado: ")
                    val dni = readLine()!!.toLong()
                    pago.pagodecuota(dni)

                }
                8->{
                    println("Lista de Cuotas")
                    for(cuota in pago.cuotas) {
                        println("${cuota.asociado.Nombre} ${cuota.asociado.Apellido}:  Fecha de venciminto: ${cuota.FechaVencimiento}  Fecha de Pago: ${cuota.FechaPago}  Estado de cuota: ${cuota.EstadoCuota}")
                    }

                }
                9->{
                    pago.listado()
                }
            }
        }while (x != 0)



    }
}