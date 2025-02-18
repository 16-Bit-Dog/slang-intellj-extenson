package slanglsp;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class SlangSyntaxHighlighter extends SyntaxHighlighterBase
{

    @Override
    public @NotNull Lexer getHighlightingLexer()
    {
        return null;
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType iElementType)
    {
        return new TextAttributesKey[0];
    }
}
