package EncodersDecoders

import chisel3._
import chisel3.util._

class Decoder() extends Module { 
    val io = IO(new Bundle {
        val  sel = Input(UInt(2.W))
        val  b = Output(UInt(4.W))
    })


    //using switch statement
    io.b := 0.U
    switch(io.sel) {
        is (0.U) { io.b := 1.U}
        is (1.U) { io.b := 2.U}
        is (2.U) { io.b := 4.U}
        is (3.U) { io.b := 8.U}
    }

}