package co.company

class Donación {

    fun donacion(gestor: Gestor){
        print("Ingrece la cantidad de donantes requeridos:")
        val cant = readLine()!!.toInt()
        print("Ingrece el tipo de sangre: ")
        val sangre = readLine().toString()
        var i: Int =0
        println("Lista de donantes: ")
        for(asociado in gestor.asociados ) {
            if (asociado.Estado == "Activo") {
                if (cant != i) {
                    if (asociado.Donaciones == 2) {
                        when (sangre) {
                            "0" -> {
                                if (asociado.GrupoSanguineo == "0") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                            "A" -> {
                                if (asociado.GrupoSanguineo == "A" || asociado.GrupoSanguineo == "0") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                            "B" -> {
                                if (asociado.GrupoSanguineo == "B" || asociado.GrupoSanguineo == "0") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                            "AB" -> {
                                if (asociado.GrupoSanguineo == "B" || asociado.GrupoSanguineo == "0" || asociado.GrupoSanguineo == "A" || asociado.GrupoSanguineo == "AB") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }

                        }
                    }
                }
            }
        }
        for(asociado in gestor.asociados ) {
            if (asociado.Estado == "Activo") {
                if (cant != i) {
                    if (asociado.Donaciones == 1) {
                        when (sangre) {
                            "0" -> {
                                if (asociado.GrupoSanguineo == "0") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                            "A" -> {
                                if (asociado.GrupoSanguineo == "A" || asociado.GrupoSanguineo == "0") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                            "B" -> {
                                if (asociado.GrupoSanguineo == "B" || asociado.GrupoSanguineo == "0") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                            "AB" -> {
                                if (asociado.GrupoSanguineo == "B" || asociado.GrupoSanguineo == "0" || asociado.GrupoSanguineo == "A" || asociado.GrupoSanguineo == "AB") {
                                    println("${asociado.Nombre} ${asociado.Apellido}")
                                    i += 1
                                }
                            }
                        }
                    }
                }
            }
        }
        if (cant > i){
            println("No hay cantidad suficiente de donates disponibles")
        }
    }
}

