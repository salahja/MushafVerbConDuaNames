package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa.*;

   
public class PastMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("أَءْ","آ"));// EX: (آثَرَ، آتَى، آخَى، آوَى، )
        substitutions.add(new InfixSubstitution("ءَا","آ"));// EX: (آضَّ، تَآجَّ، آجَرَ، تآكَلَ، آوَبَ، انْآدَ، تآوَبَ، آيَسَ، آيَدَ، آسَى، تآخَى، آسى، تآثَى، تآوَى، )
        substitutions.add(new InfixSubstitution("ءَ","أَ"));// EX: (أمَّمَ، تأمَّمَ، اسْتأمَّ، أثَّر، انأطَرَ، تأكَّدَ، أوَّب، تأوَّبَ، أيَّدَ، تأيَّدَ، أبَّى، تأسَّى، أدَّى، تأتَّى، أوَّى، تأوَّى، )
        substitutions.add(new InfixSubstitution("اءْ","ائْ"));// EX: (ائْتَمَّ، ائْتَثَأَ، ائْتَمَرَ، ائْتَالَ، ائْتامَ، ائْتَسَى، ائْتَرَى، ائْتَوَى، )
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (اسْتَأْمَرَ، اسْتَأْوَرَ، استأيَكَ، اسْتَأمَى، استأنَى، اسْتَأْوَى، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
