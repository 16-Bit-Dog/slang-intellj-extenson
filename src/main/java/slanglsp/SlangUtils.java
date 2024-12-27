package slanglsp;

import java.io.File;
import java.nio.file.Paths;

import com.intellij.openapi.application.PathManager;
import com.intellij.psi.tree.IElementType;

import static java.util.List.of;

public class SlangUtils
{
    static IElementType L_BRACKET = new IElementType("[", SlangLanguage.INSTANCE);
    static IElementType R_BRACKET = new IElementType("]", SlangLanguage.INSTANCE);
    static IElementType L_CURLY = new IElementType("{", SlangLanguage.INSTANCE);
    static IElementType R_CURLY = new IElementType("}", SlangLanguage.INSTANCE);
    static IElementType L_PARENTHESIS = new IElementType("(", SlangLanguage.INSTANCE);
    static IElementType R_PARENTHESIS = new IElementType(")", SlangLanguage.INSTANCE);

    static String getPluginDir()
    {
        String jarPath = PathManager.getJarPathForClass(SlangUtils.class);
        if(jarPath == null)
            throw new RuntimeException("Invalid 'getJarPathForClass'");
        return Paths.get(jarPath).getParent().toString()+"/";
    }
    static String getVersionCacheLocation()
    {
        return Paths.get(slanglsp.SlangUtils.getPluginDir())+"\\versionCache.txt";
    }
    static File getVersionCacheFile()
    {
        return Paths.get(getVersionCacheLocation()).toFile();
    }

    static SlangVersion getVersion()
    {
        var fileStream = SlangUtils.class.getClassLoader().getResourceAsStream("version.txt");
        if(fileStream == null)
        {
            System.out.println("Missing the resource version.txt");
            return new SlangVersion("0.0");
        }
        return new SlangVersion(fileStream);
    }
}
