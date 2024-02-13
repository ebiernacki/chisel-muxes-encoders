package EncodersDecoders


import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class EncoderTest extends AnyFlatSpec with ChiselScalatestTester {

    "OH Encoder" should s"encode 1:4 " in {
        test(new Encoder) { dut =>
            dut.io.input.poke("b0001".U) 
            dut.io.output.expect(0.U) 

            dut.io.input.poke("b0010".U)
            dut.io.output.expect(1.U) 

            dut.io.input.poke("b0100".U) 
            dut.io.output.expect(2.U) 

            dut.io.input.poke("b1000".U) 
            dut.io.output.expect(3.U) 

            dut.io.input.poke("b1000".U) 
            dut.io.output.expect(3.U) 
            
        }
    }

    "Priority Encoder" should "encode the highest-priority input correctly" in {
        test(new PriorityEncoderExample) { dut =>
            dut.io.input.poke("b0110".U) 
            dut.io.output.expect(1.U) 

            dut.io.input.poke("b0010".U) 
            dut.io.output.expect(1.U) 

            dut.io.input.poke("b0100".U) 
            dut.io.output.expect(2.U) 

            dut.io.input.poke("b1000".U) 
            dut.io.output.expect(3.U) 

            dut.io.input.poke("b1010".U) 
            dut.io.output.expect(1.U) 

            dut.io.input.poke("b0101".U) 
            dut.io.output.expect(0.U)

            
        }
    }
}