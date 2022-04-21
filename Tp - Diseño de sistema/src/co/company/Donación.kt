package co.company

class Donación {

    fun donacion(gestor: Gestor){
        println("Ingrece la cantidad de donantes requeridos:")
        val cant = readLine()!!.toInt()
        var i: Int =0
        println("Lista de donantes: ")
        for(asociado in gestor.asociados ){

            if (cant != i){
                if (asociado.Donaciones == 2){
                    println("${asociado.Donaciones}")
                    println("${asociado.Nombre} ${asociado.Apellido}")
                    i += 1
                }
            }
        }

        for(asociado in gestor.asociados ){

            if (cant != i){
                if (asociado.Donaciones == 1) {
                    println("${asociado.Nombre} ${asociado.Apellido}")
                    i += 1
                }
            }

        }


        if (cant > i){
            println("No hay cantidad suficiente de donates disponibles")
        }
    }
}