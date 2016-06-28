// http://www.ashishsharma.me/2011/08/external-merge-sort.html

public class ExternalSort
{
	public static ArrayList<File> sortInBatch(File file, Comparator<String> cmp) throws IOException {
	
		ArrayList<File> files = new ArrayList<File>();
		BufferedReader fbr = new BufferedReader(new FileReader(file));
		long blocksize = 1000000;
		
		try {
			List<String> tmpList = new ArrayList<String>();
			String line = "";
			
			try {
				while (line != null) {
					long currentblocksize = 0;
					while ((currentblocksize < blocksize) &&
						((line = fbr.readLine()) != null) {
							tmpList.add(line);
							currentblocksize += line.length();
						}
						
						files.add(sortAndSave(tmplist,cmp));
						tmplist.clear();
				}
			}
		}
	}
	
	public static File sortAndSave(List<String> tmpList, Comparator<String> cmp)
	{
		Collections.sort(tmpList, cmp);
		File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
		nettmpfile.delteOnExit();
		BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
		
		for (String tmp : tmpList) {
			fbw.writeLine(tmp);
		}
	}
	
	void merge(List<File> tmpFiles, File outputfile, Comparator<String> cmp)
	
	{
		boolean notEmpty = true;
		
		while (notEmpty) {
			notEmpty = false;
		ArrayList<String> lines = new ArrayList<>();
		for (File f : files) {
			lines.add(f.getFirstLine()); // there is cost of getting these
		}
			Collections.sort(lines, cmp);
			coutputfile.write(lines);			
			if (f.hasLine()) {
				notEmpty = true;
			}
		}
		
		
	}
}


