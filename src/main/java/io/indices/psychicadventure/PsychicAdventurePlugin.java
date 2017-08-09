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

import com.voxelgameslib.voxelgameslib.game.GameHandler;
import com.voxelgameslib.voxelgameslib.game.GameMode;
import com.voxelgameslib.voxelgameslib.lang.LangHandler;
import com.voxelgameslib.voxelgameslib.module.Module;
import com.voxelgameslib.voxelgameslib.module.ModuleHandler;
import com.voxelgameslib.voxelgameslib.module.ModuleInfo;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;

@Singleton
@ModuleInfo(name = "PsychicAdventure", authors = "aphel", version = "1.0")
public class PsychicAdventurePlugin extends JavaPlugin implements Module {
    public static final GameMode GAMEMODE = new GameMode("TroubleInMinecraft", PsychicAdventureGame.class);

    @Inject
    private GameHandler gameHandler;
    @Inject
    private LangHandler langHandler;

    @Override
    public void onLoad() {
        ModuleHandler.offerModule(this);
    }

    @Override
    public void enable() {
        gameHandler.registerGameMode(GAMEMODE);

        langHandler.registerExternalLangProvider(PALangKey.PSYCHIC_ADVENTURE, new File(getDataFolder(), "lang"));
    }

    @Override
    public void disable() {
        //
    }
}
