#!/bin/sh
java -Dfile.encoding=UTF-8 -classpath build be.ac.ulg.montefiore.run.jahmm.apps.cli.Cli learn-bw -opdf integer -r 27416 -i /home/anjan/workspace/SRL-anjan/myconll2005/final/verbaware/verbknown__VERB__/learned__VERB__.hmm -o /home/anjan/workspace/SRL-anjan/myconll2005/final/verbaware/verbknown__VERB__/learned.more.__VERB__.hmm  -is /home/anjan/workspace/SRL-anjan/myconll2005/final/verbaware/verbknown__VERB__/combined.__VERB__.seq.trunc  -ni 20