class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashSet<String> high = new HashSet<String>();
        ArrayList<Pair<String, Integer>> entries= new ArrayList<Pair<String, Integer>>(access_times.size());
        for(int i = 0; i < access_times.size(); i++)
        {
            List<String> entry = access_times.get(i);
            int hrs = Integer.parseInt(entry.get(1).substring(0, 2));
            int mins = Integer.parseInt(entry.get(1).substring(2, 4));
            entries.add(new Pair<String, Integer>(entry.get(0), hrs * 60 + mins));
        }
        entries.sort((Pair<String, Integer> entry1, Pair<String, Integer> entry2) -> {
            int time1 = entry1.getValue();
            int time2 = entry2.getValue();
            if (time1 < time2)
                return -1;
            else if (time1 > time2)
                return 1;
            else
                return 0;
        });
        HashMap<String, Integer> emp_freq = new HashMap<String, Integer>();
        for (int i = 0; i < entries.size()-1; i++)
        {
            int hr = entries.get(i).getValue() + 60;
            for (int k = i; k < entries.size(); k++)
            {
                int time = entries.get(k).getValue();
                if (time >= hr)
                {
                    emp_freq.clear();
                    break;
                }
                String emp = entries.get(k).getKey();
                Integer freq = emp_freq.get(emp);
                int newFreq = freq == null ? 1 : freq + 1;
                if (newFreq >= 3)
                    high.add(emp);
                emp_freq.put(emp, newFreq);
            }
            emp_freq.clear();
        }
        return new ArrayList<String>(high);
    }
}