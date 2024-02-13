package EncodersDecoders


import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class DecoderTest extends AnyFlatSpec with ChiselScalatestTester {

    "Decoder Test" should s"dencode 1:4 " in {
        test(new Decoder) { dut =>

            dut.io.input.poke(0.U)
            dut.io.output.expect(1.U)
            
            dut.io.input.poke(1.U)
            dut.io.output.expect(2.U)
            
            dut.io.input.poke(2.U)
            dut.io.output.expect(4.U)
            
            dut.io.input.poke(3.U)
            dut.io.output.expect(8.U)
        }
    }
}