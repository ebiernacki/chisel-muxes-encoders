package EncodersDecoders

import chisel3._
import chisel3.util._

//Fill in the Decoder Module using the switch statement to decode a 2 bit signal to a 4 bit signal

class Decoder() extends Module { 
    val io = IO(new Bundle {
        val  input = Input(UInt(2.W))
        val  output = Output(UInt(4.W))
    })


    

}