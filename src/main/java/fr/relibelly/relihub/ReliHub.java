package fr.relibelly.relihub;

import fr.relibelly.relihub.commands.SpawnCommand;
import fr.relibelly.relihub.managers.ListenersManager;
import fr.relibelly.relihub.scoreboard.ScoreboardManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class ReliHub extends JavaPlugin {

    private static ReliHub instance;
    private ScoreboardManager scoreboardManager;
    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public void onEnable() {
        instance = this;
        new ListenersManager(this).registerListeners();
        getCommand("spawn").setExecutor(new SpawnCommand());
        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();
    }

    public static ReliHub getInstance() {
        return instance;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    @Override
    public void onDisable() {
        getScoreboardManager().onDisable();
    }
}
