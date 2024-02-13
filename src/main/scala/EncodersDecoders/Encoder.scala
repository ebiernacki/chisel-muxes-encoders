package EncodersDecoders

import chisel3._
import chisel3.util._

//Fill in the Encoder Module using the switch statement to encode a 4 bit signal to a 2 bit signal
//You can assume the input signal is a one hot encoded signal
class Encoder extends Module { 
    val io = IO(new Bundle {
        val input = Input(UInt(4.W))
        val output = Output(UInt(2.W))
    })

    // Implementing the one-hot encoder using built in module
    // io.output := OHToUInt(io.input) //this can handle any width by varying input 

    //have to set default
    io.output := "b00".U
    switch(io.input) {
        is ("b0001".U) { io.output := "b00".U} //or 0.U
        is ("b0010".U) { io.output := "b01".U} //   1.U
        is ("b0100".U) { io.output := "b10".U} //   2.U
        is ("b1000".U) { io.output := "b11".U} //   3.U
    }

}



//Just an example
class PriorityEncoderExample extends Module {
    val io = IO(new Bundle {
        val input = Input(UInt(4.W))
        val output = Output(UInt(4.W))
    })

    // Implementing the priority encoder with the built in module
    io.output := PriorityEncoder(io.input)

}
