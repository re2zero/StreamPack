/*
 * Copyright (C) 2021 Thibault B.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.thibaultbee.streampack.ext.srt.regulator.srt

import io.github.thibaultbee.srtdroid.models.Stats
import io.github.thibaultbee.streampack.data.BitrateRegulatorConfig
import io.github.thibaultbee.streampack.regulator.BitrateRegulator
import io.github.thibaultbee.streampack.regulator.IBitrateRegulatorFactory

/**
 * Base class of bitrate regulation implementation.
 * If you want to implement your custom bitrate regulator, it must inherit from this class.
 * The bitrate regulator object is created by streamers with the [IBitrateRegulatorFactory].
 *
 * @param bitrateRegulatorConfig bitrate regulation configuration
 * @param onVideoTargetBitrateChange call when you have to change video bitrate
 * @param onAudioTargetBitrateChange call when you have to change audio bitrate
 */
abstract class SrtBitrateRegulator(
    bitrateRegulatorConfig: BitrateRegulatorConfig,
    onVideoTargetBitrateChange: ((Int) -> Unit),
    onAudioTargetBitrateChange: ((Int) -> Unit)
) : BitrateRegulator(
    bitrateRegulatorConfig,
    onVideoTargetBitrateChange,
    onAudioTargetBitrateChange
) {

    /**
     * Call regularly to get new SRT stats
     *
     * @param stats SRT transmission stats
     * @param currentVideoBitrate current video bitrate target
     * @param currentAudioBitrate current audio bitrate target
     */
    abstract fun update(stats: Stats, currentVideoBitrate: Int, currentAudioBitrate: Int)
}