package stus.content;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.BurstDrill;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;


public class StuasutBlocks {
    public static Block

            //environment
            gertwall, limestonewall, gert, limestone, mercurymud, orezinc, orebarium, orecadmium, orerhenium, oreantimony,

    //defence
    bariumWall, bariumWallLarge, cadmiumWall, cadmiumWallLarge, rheniumWall, rheniumWallLarge,

    //crafting
    //furnace,

    //production
    zinccrusher,

    //power
    windgenerator, zincbattery, zincbatterylarge, zincnode, zincnodelarge,

    //storage
    coreDawn;

    //distribution


    //turrets
    //togi, pulse, collapse,

    //units


    public void load() {
        //environment
        gert = new Floor("gert") {{
            playerUnmineable = true;
            variants = 3;
        }};
        gertwall = new StaticWall("gert-wall") {{
            variants = 3;
        }};
        limestonewall = new StaticWall("limestone-wall") {{
            variants = 3;
        }};
        mercurymud = new Floor("mercury-mud") {{
            variants = 3;
        }};
        limestone = new Floor("limestone") {{
            variants = 3;
        }};
        orezinc = new OreBlock(StuasutItems.zinc) {{
            oreDefault = true;
        }};
        orebarium = new OreBlock(StuasutItems.bariumraw) {{
            oreDefault = true;
        }};
        orecadmium = new OreBlock(StuasutItems.cadmiumraw) {{
            oreDefault = true;
        }};
        orerhenium = new OreBlock(StuasutItems.rheniumraw) {{
            oreDefault = true;
        }};
        oreantimony = new OreBlock(StuasutItems.antimonyraw) {{
            oreDefault = true;
        }};
        //defence
        bariumWall = new Wall("barium-wall"){{
            requirements(Category.defense, with(StuasutItems.barium, 6));
            health = 80 * 6;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bariumWallLarge = new Wall("barium-wall-large"){{
            requirements(Category.defense, with(StuasutItems.barium, 24));
            health = 80 * 6 * 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
            size = 2;
        }};
        cadmiumWall = new Wall("cadmium-wall"){{
            requirements(Category.defense, with(StuasutItems.cadmium, 6));
            health = 80 * 10;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        cadmiumWallLarge = new Wall("cadmium-wall-large"){{
            requirements(Category.defense, with(StuasutItems.cadmium, 24));
            health = 80 * 8 * 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
            size = 2;
        }};
        rheniumWall = new Wall("rhenium-wall"){{
            requirements(Category.defense, with(StuasutItems.rhenium, 6));
            health = 80 * 10;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        rheniumWallLarge = new Wall("rhenium-wall-large"){{
            requirements(Category.defense, with(StuasutItems.rhenium, 24));
            health = 80 * 8 * 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
            size = 2;
        }};

        //crafting
        
            //nothing yet, we'll see

        //production

        zinccrusher = new BurstDrill("zinc-crusher"){{
            requirements(Category.production, with(StuasutItems.zinc, 12, StuasutItems.bariumraw, 6));
            drillTime = 64f * 5f;
            size = 2;
            hasPower = true;
            tier =2;
            drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            shake = 3;
            itemCapacity = 10;
            researchCostMultiplier = 0.5f;
            fogRadius = 1;
            consumePower(0.5f / 60f);
        }};

        //power

        windgenerator = new ConsumeGenerator("wind-generator"){
            {
                size = 2;
                requirements(Category.power, with(StuasutItems.zinc, 20, StuasutItems.bariumraw, 8));
                powerProduction = 0.5f;
                drawer = new DrawMulti(new DrawRegion("-rotator"));
            }};

            //storage

            coreDawn = new CoreBlock("core-shard"){{
                requirements(Category.effect, BuildVisibility.editorOnly, with(StuasutItems.zinc, 2000, StuasutItems.dencealloy, 560, StuasutItems.barium, 800));
                alwaysUnlocked = true;

                isFirstTier = true;
                unitType = UnitTypes.alpha;
                health = 3000;
                itemCapacity = 4000;
                size = 4;
                unitCapModifier = 6;
            }};

        //turrets

    }
}
