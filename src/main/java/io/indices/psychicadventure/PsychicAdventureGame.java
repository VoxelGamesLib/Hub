/*
 * Copyright (c) 2017 aphel - MIT license
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.indices.psychicadventure;

import com.voxelgameslib.voxelgameslib.game.AbstractGame;
import com.voxelgameslib.voxelgameslib.game.GameDefinition;
import com.voxelgameslib.voxelgameslib.game.GameInfo;

import javax.annotation.Nonnull;

@GameInfo(name = "PsychicAdventure", author = "aphel", version = "1.0", description = "Just a little micro-game with mazes, potions and mobs.")
public class PsychicAdventureGame extends AbstractGame {

    public PsychicAdventureGame() {
        super(PsychicAdventurePlugin.GAMEMODE);
    }

    @Override
    public void initGameFromModule() {
        setMinPlayers(Integer.MAX_VALUE);
        setMaxPlayers(Integer.MAX_VALUE);

        activePhase = createPhase(PsychicAdventurePhase.class);

        loadMap("Hub");
    }

    @Override
    public void initGameFromDefinition(@Nonnull GameDefinition gameDefinition) {
        super.initGameFromDefinition(gameDefinition);

        loadMap("Hub");
    }
}
