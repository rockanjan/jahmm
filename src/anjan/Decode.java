package anjan;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import be.ac.ulg.montefiore.run.jahmm.Hmm;
import be.ac.ulg.montefiore.run.jahmm.Observation;
import be.ac.ulg.montefiore.run.jahmm.ObservationInteger;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import be.ac.ulg.montefiore.run.jahmm.ViterbiCalculator;
import be.ac.ulg.montefiore.run.jahmm.io.FileFormatException;
import be.ac.ulg.montefiore.run.jahmm.io.HmmReader;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationIntegerReader;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationSequencesReader;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationVectorReader;
import be.ac.ulg.montefiore.run.jahmm.io.OpdfIntegerReader;
import be.ac.ulg.montefiore.run.jahmm.io.OpdfReader;

public class Decode {
	public static void main(String[] args) throws IOException, FileFormatException{
		PrintWriter pw = new PrintWriter(new File("/home/anjan/work/conll05-backup/punct/combined/combined.hmm.new.out"));
		Reader reader = new FileReader("/home/anjan/work/conll05-backup/punct/combined/combined.sequence.jahmm") ;
		Reader hmmReader = new FileReader("/home/anjan/work/conll05-backup/punct/combined/server07_learned.300iter.hmm");
		//Hmm<ObservationInteger> hmm = HmmReader.read(hmmReader, new OpdfIntegerReader(15383));
		Hmm<ObservationInteger> hmm = HmmReader.read(hmmReader, new OpdfIntegerReader(15353));
		List<List<ObservationInteger>> seqs = ObservationSequencesReader.readSequences(new ObservationIntegerReader(), reader );
		reader.close() ;
		hmmReader.close();
		for(List<ObservationInteger> seq : seqs){
			ViterbiCalculator vc = new ViterbiCalculator(seq, hmm);
			int[] states = hmm.mostLikelyStateSequence(seq);
			
			for(int state : states){
			//for(int state : vc.stateSequence()){
				pw.println(state);
			}
			
			pw.flush();
			pw.println();
		}
		
		pw.flush();
		pw.close();
		System.out.println("Done!");
	}
}
