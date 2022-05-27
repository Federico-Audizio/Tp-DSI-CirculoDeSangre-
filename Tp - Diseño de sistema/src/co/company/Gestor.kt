package co.company

import java.text.SimpleDateFormat
import java.util.*


class Gestor (
    val asociados: ArrayList<Asociado> = arrayListOf()
        ) {

    fun agregaeAsociado(): Boolean {


        println("Ingresar datos del asociado")
        print("Ingrece DNI: ")
        val dni= readLine()!!.toLong()
        print("Ingrece Nombre: ")
        val nombre= readLine().toString()
        print("Ingrece Apellido: ")
        val apellido= readLine().toString()
        print("Ingrese fecha de nacimineto (dd/MM/yyyy): ")
        val fechanacimineto= readLine()
        val fechanaciminetodata: Date=SimpleDateFormat("dd/MM/yyyy").parse(fechanacimineto)
        print("Ingrece Domicilio: ")
        val domicilio= readLine().toString()
        print("Ingrece Localidad: ")
        val localidad= readLine().toString()
        print("Ingrece Teléfono: ")
        val telefono= readLine()!!.toLong()
        print("Ingrece Email: ")
        val email= readLine().toString()
        print("Ingrece Grupo Sanguíneo(A,B,AB,0): ")
        val gruposanguineo= readLine().toString()
        val factor= "-"

        val fechaActual= Date(System.currentTimeMillis())
        val diferenciaFechaMili = fechaActual.time - fechanaciminetodata.time
        val edad = (((((diferenciaFechaMili/1000)/60)/60)/24)/365)
        var estado = if( edad < 18 || edad > 56) "Pasivo"
        else "Activo"


        print("Tiene una enfermedad cronica (1-Si  2-No): ")
        val enfermedad= readLine()!!.toInt()
        val enfermedadcronica:String
        val medicacion: String
        if (enfermedad == 1) {
            print("Ingrece Enfermedad cronica: ")
            enfermedadcronica = readLine().toString()
            print("Ingrece Medicación: ")
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
            fechanacimineto,
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

        println("")
        println("El reglamento del circuito es:...")
        println("El importe de las cuotas es de ...")
        println("Las formas de pago son ...")
        print("Esta de acuerdo (1-Si 2-No): ")
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
                else {
                    println("Este asociado no puede realizar donaciones")
                    return
                }
            }
        }
        println("No se encuentra un asociado con este DNI")
    }

}