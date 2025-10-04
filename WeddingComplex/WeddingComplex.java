import java.util.*;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> couples = new HashMap<>();
        Map<String, String> engaged = new HashMap<>();
        Map<String, Integer> nextProposalIndex = new HashMap<>();

        for (String person : first.keySet()) {
            nextProposalIndex.put(person, 0);
        }

        while (couples.size() < first.size()) {
            String freePerson = null;

            for (String person : first.keySet()) {
                if (!couples.containsKey(person) && nextProposalIndex.get(person) < first.get(person).size()) {
                    freePerson = person;
                    break;
                }
            }

            if (freePerson == null) break;

            List<String> preferences = first.get(freePerson);
            int index = nextProposalIndex.get(freePerson);
            String preferred = preferences.get(index);
            nextProposalIndex.put(freePerson, index + 1);

            if (!engaged.containsKey(preferred)) {
                engaged.put(preferred, freePerson);
                couples.put(freePerson, preferred);
            } else {
                String currentPartner = engaged.get(preferred);
                List<String> theirPreferences = second.get(preferred);

                if (theirPreferences.indexOf(freePerson) < theirPreferences.indexOf(currentPartner)) {
                    engaged.put(preferred, freePerson);
                    couples.remove(currentPartner);
                    couples.put(freePerson, preferred);
                }
            }
        }

        return couples;
    }
}
