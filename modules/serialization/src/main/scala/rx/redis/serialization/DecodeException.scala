/*
 * Copyright 2014 – 2015 Paul Horn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rx.redis.serialization

import rx.redis.resp.RespType

final class DecodeException[Expected] private (val resp: RespType, reason: Throwable)
  extends IllegalArgumentException(s"Could not decode [$resp]", reason)

object DecodeException {
  def apply[A](resp: RespType): DecodeException[A] =
    new DecodeException[A](resp, null)

  def apply[A](resp: RespType, reason: Throwable): DecodeException[A] =
    new DecodeException[A](resp, reason)
}