package io.github.yurysavchuk.sealed;

public sealed interface Command permits LoginCommand, LogoutCommand, PluginCommand {

}
