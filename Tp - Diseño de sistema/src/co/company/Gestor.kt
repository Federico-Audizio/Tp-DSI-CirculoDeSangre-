package co.company

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class Gestor (
    val asociados: ArrayList<Asociado> = arrayListOf()
        ) {

    fun agregaeAsociado(): Boolean {

        println("Ingresar datos del asociado")
        println("Ingrece DNI: ")
        val dni= readLine()!!.toLong()
        println("Ingrece Nombre: ")
        val nombre= readLine().toString()
        println("Ingrece Apellido: ")
        val apellido= readLine().toString()
        print("Ingrece día de nacimiento: ")
        val dianacimiento= readLine()!!.toInt()
        print("Ingrece mes de nacimiento: ")
        val mesnacimiento= readLine()!!.toInt()
        print("Ingrece año de nacimiento: ")
        val anionacimiento= readLine()!!.toInt()


        /*
        val myDateObj = LocalDateTime.now()
        println("Ingrese la fecha de nacimiento: ")
        val myFormatObj = DateTimeFormatter.ofPattern(readLine())

        println("${myDateObj}, ${myFormatObj}")


        val formattedDate: String = myDateObj.format(myFormatObj)
        println("After formatting: $formattedDate")


         */
        println("Ingrece Domicilio: ")
        val domicilio= readLine().toString()
        println("Ingrece Localidad: ")
        val localidad= readLine().toString()
        println("Ingrece Teléfono: ")
        val telefono= readLine()!!.toLong()
        println("Ingrece Email: ")
        val email= readLine().toString()
        println("Ingrece Grupo Sanguíneo: ")
        val gruposanguineo= readLine().toString()
        println("Ingrece Factor: ")
        val factor= readLine().toString()

        var estado: String

        if ((Calendar.getInstance().get(Calendar.YEAR) - anionacimiento < 18) or (Calendar.getInstance().get(Calendar.YEAR) - anionacimiento > 56)){
            estado = "Pasivo"
        }
        else{
            if ((Calendar.getInstance().get(Calendar.YEAR) - anionacimiento == 18) or (Calendar.getInstance().get(Calendar.YEAR) - anionacimiento == 56)){
                if ((Calendar.getInstance().get(Calendar.MONTH) < mesnacimiento))estado = "Pasivo"
                else{
                    if ((Calendar.getInstance().get(Calendar.MONTH)+1 == mesnacimiento)){
                        if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < dianacimiento){
                            estado = "Pasivo"
                        }
                        else estado = "Activo"
                    }
                    else estado = "Activo"
                    }
                }
            else estado = "Activo"
        }


        println("Tiene una enfermedad cronica:  1-Si  2-No")
        val enfermedad= readLine()!!.toInt()
        val enfermedadcronica:String
        val medicacion: String
        if (enfermedad == 1) {
            println("Ingrece Enfermedad cronica: ")
            enfermedadcronica = readLine().toString()
            println("Ingrece Medicación: ")
            medicacion = readLine().toString()
            estado = "Pasivo"
        }
        else{
            enfermedadcronica = null.toString()
            medicacion= null.toString()
        }


        val donaciones = 2

        val asociado1= Asociado(
            DNI = dni,
            Nombre = nombre,
            Apellido = apellido,
            AnioNacimiento = anionacimiento,
            MesNacimiento = mesnacimiento,
            DiaNacimiento = dianacimiento,
            Domicilio = domicilio,
            Localidad = localidad,
            Telefono = telefono,
            Email = email,
            GrupoSanguineo = gruposanguineo,
            Factor = factor,
            EnfermedadCronica = enfermedadcronica,
            Medicacion = medicacion,
            Donaciones = donaciones,
            Estado = estado,
        )

        println("El reglamento del circuito es:...")
        println("El importe de las cuotas es de ...")
        println("Las formas de pago son ...")
        println("Esta de acuerdo:   1-Si 2-No")
        val acuerdo= readLine()!!.toInt()
        if (acuerdo == 1) {
            return asociados.add(asociado1)
        }
        else{
            return false
        }
    }


    fun donaciones (dni: Long) {
        for(asociado in asociados) {
            if (asociado.DNI == dni){
                if (asociado.Estado == "Activo"){
                    if(asociado.Donaciones > 0){
                        asociado.Donaciones = asociado.Donaciones - 1
                        println("Se registro donación")
                        return
                    }
                    println("No puede donar mas de dos veces en un año")
                    return
                }
                else println("Este asociado no puede realizar donaciones")
            }
        }
        println("No se encuentra un asociado con este DNI")
    }


}