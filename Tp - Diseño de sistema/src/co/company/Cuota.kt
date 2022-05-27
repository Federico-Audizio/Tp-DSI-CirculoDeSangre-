package co.company

class Cuota(
        var asociado: Asociado,
        val Importe: Float,
        val FechaVencimiento: Int,
        var FechaPago: Int?,
        var EstadoCuota: String
        ){



}