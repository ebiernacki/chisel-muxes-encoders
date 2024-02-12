package EncodersDecoders


import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class DecoderTest extends AnyFlatSpec with ChiselScalatestTester {

    "Decoder Test" should s"dencode 1:4 " in {
        test(new Decoder) { dut =>
            dut.io.sel.poke(1.U)
            
            dut.io.b.expect(2.U)
            
        }
    }
}