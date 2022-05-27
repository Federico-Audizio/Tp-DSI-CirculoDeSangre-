package co.company

import java.util.*

class pago (val cuotas: ArrayList<Cuota> = arrayListOf())
{
    fun GenerarCuota(asociado: Asociado, importeActivo: Float, importePasivo: Float){
        val importedecuota: Float
        val estadocuota: String
        if (asociado.Estado == "Activo") {
            importedecuota = importeActivo
        } else {
            importedecuota = importePasivo
        }
        estadocuota = "Pendiente"
        val fechavencimiento = Calendar.getInstance().get(Calendar.DATE) + 1
        val cuota = Cuota(asociado, importedecuota, fechavencimiento, null , estadocuota)
        cuotas.add(cuota)
        return
    }

    fun pagodecuota(dni: Long) {
        for(cuota in cuotas) {
            if (cuota.asociado.DNI == dni) {
                println("Su importe es de: ${cuota.Importe}")
                println("Desea relizar el pago: 1-Si 2-No")
                val i = readLine()!!.toInt()
                if (i == 1) {
                    cuota.EstadoCuota= "Paga"
                    cuota.FechaPago=Calendar.getInstance().get(Calendar.DATE)
                } else {
                    cuota.EstadoCuota = "Pendiente"
                }

            }
    }
        return}


    fun listado (){
        var imptotalactivo = 0
        var imptotalrecactivo = 0
        var contact = 0
        var contactpago = 0
        var imptotalpasivo = 0
        var imptotalrecpasivo = 0
        var contpas = 0
        var contpaspago = 0

        for (cuota in cuotas) {
            if (cuota.asociado.Estado == "Activo") {
                imptotalactivo += cuota.Importe.toInt()
                contact += 1
                if (cuota.EstadoCuota == "Paga") {
                    imptotalrecactivo += cuota.Importe.toInt()
                    contactpago += 1
                }
            } else {
                imptotalpasivo += cuota.Importe.toInt()
                contpas += 1
                if (cuota.EstadoCuota == "pago"){
                    imptotalrecpasivo += cuota.Importe.toInt()
                    contpaspago += 1
                }
            }
        }
        println("El importe a recaudar de la categoria activo es $imptotalactivo")
        println("El importe a recaudar de la categoria pasivo es $imptotalpasivo")
        println("El importe recaudado de la categoria activo es $imptotalrecactivo")
        println("El importe recaudado de la categoria pasivo es $imptotalrecpasivo")
        println("El porsentage ${((contactpago/ contact) * 100)}")
        println("El porsentage ${((contpaspago/ contpas) * 100)}")

    }
}