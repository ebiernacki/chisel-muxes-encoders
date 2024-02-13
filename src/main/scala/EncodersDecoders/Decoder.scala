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















/* 
Decoder:
    //have to set default
    io.output := 0.U

    switch(io.input) {
        is (0.U) { io.output := 1.U}
        is (1.U) { io.output := 2.U}
        is (2.U) { io.output := 4.U}
        is (3.U) { io.output := 8.U}
    }

 */