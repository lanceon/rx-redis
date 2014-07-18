package rx.redis
package pipeline

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelPipeline
import io.reactivex.netty.pipeline.PipelineConfigurator

import rx.redis.protocol.Decoder
import rx.redis.resp.RespType


private[redis] final class Configurator extends PipelineConfigurator[RespType, ByteBuf] {
  def configureNewPipeline(pipeline: ChannelPipeline): Unit = {
    pipeline.addLast(new Decoder)
  }
}
