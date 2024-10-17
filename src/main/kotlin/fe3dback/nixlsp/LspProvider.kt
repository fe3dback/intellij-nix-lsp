package fe3dback.nixlsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem
import com.intellij.openapi.util.IconLoader

object NixLSPIcons {
    @JvmField
    var FILETYPE_ICON = IconLoader.getIcon("/META-INF/pluginIcon.svg", NixLSPIcons::class.java)
}

internal class LspProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.extension == "nix") {
            serverStarter.ensureServerStarted(FooLspServerDescriptor(project))
        }
    }

    override fun createLspServerWidgetItem(lspServer: LspServer, currentFile: VirtualFile?): LspServerWidgetItem {
        return LspServerWidgetItem(
            lspServer, currentFile,
            NixLSPIcons.FILETYPE_ICON
        )
    }
}

private class FooLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "nix") {
    override fun isSupportedFile(file: VirtualFile) = file.extension == "nix"
    override fun createCommandLine() = GeneralCommandLine("nixd")
}