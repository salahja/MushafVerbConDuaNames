package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.PrefixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.AbstractEinMahmouz;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeMahmouz extends AbstractEinMahmouz {
    private final List substitutions = new ArrayList();

    public ImperativeMahmouz() {
        substitutions.add(new PrefixSubstitution("ءِ", "إِ"));// EX: (إِدْ [وأد]، إِ [وأى])
        substitutions.add(new PrefixSubstitution("ءُ", "أُ"));// EX: (أنتم أُوا)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ"));// EX: (امْئِي، انْئِمْ)
        substitutions.add(new InfixSubstitution("ايْءَ", "ايئَ"));// EX: (ايْئَس)
        substitutions.add(new InfixSubstitution("َيْءَ", "َيْئَ"));// EX: (يَيْئَس)
        substitutions.add(new InfixSubstitution("يءَ", "يئَ"));// EX: (ايئب)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ"));// EX: (اثْأَرْ، انْأَ[المتطرفة عروضاً لها حكم المتوسطة أصالة])
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ"));// EX: (اضْؤُل، امْؤُ[المتطرفة عروضاً لها حكم المتوسطة أصالة])
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
