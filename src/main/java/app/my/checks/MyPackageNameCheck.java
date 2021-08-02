package app.my.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class MyPackageNameCheck extends AbstractCheck {
    private static final int DEFAULT_MAX = 30;
    private int max = DEFAULT_MAX;

    @Override
    public int[] getDefaultTokens() {
        System.out.println("Hello World! : getDefaultTokens");
        return new int[] { TokenTypes.PACKAGE_DEF };
    }

    @Override
    public int[] getAcceptableTokens() {
        System.out.println("Hello World! : getAcceptableTokens");
        return null;
    }

    @Override
    public int[] getRequiredTokens() {
        System.out.println("Hello World! : getRequiredTokens");
        return null;
    }

    @Override
    public void visitToken(DetailAST ast) {
        // find the OBJBLOCK node below the CLASS_DEF/INTERFACE_DEF
        DetailAST objBlock = ast.findFirstToken(TokenTypes.OBJBLOCK);

        // count the number of direct children of the OBJBLOCK
        // that are METHOD_DEFS
        int methodDefs = objBlock.getChildCount(TokenTypes.METHOD_DEF);

        // report violation if limit is reached
        log(ast.getLineNo(), "hello world");
    }
}