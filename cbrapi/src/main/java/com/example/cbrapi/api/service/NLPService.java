package com.example.cbrapi.api.service;


import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.TokenizerME;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NLPService {

    private TokenizerME tokenizer;
    private POSTaggerME posTagger;

    public NLPService() throws Exception {
        try (
                InputStream tokenModelIn = getClass().getClassLoader()
                        .getResourceAsStream("nlpmodels/opennlp-en-ud-ewt-tokens-1.2-2.5.0.bin");
                InputStream posModelIn = getClass().getClassLoader()
                        .getResourceAsStream("nlpmodels/opennlp-en-ud-ewt-pos-1.2-2.5.0.bin")
        ) {
            if (tokenModelIn == null || posModelIn == null) {
                throw new IllegalStateException("Model files not found in resources/nlpmodels/");
            }

            TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
            tokenizer = new TokenizerME(tokenModel);

            POSModel posModel = new POSModel(posModelIn);
            posTagger = new POSTaggerME(posModel);
        }
    }

    public List<String> extractKeywords(String text){
//        System.out.println("Text: "+text);
        String[] tokens = tokenizer.tokenize(text);
        String[] tags = posTagger.tag(tokens);
//        System.out.println(Arrays.toString(tokens));

        List<String> nouns = new ArrayList<>();
        List<String> verbs = new ArrayList<>();
        List<String> adjectives = new ArrayList<>();

        List<String> keywords = new ArrayList<>();

        for (int i =0;i<tokens.length;i++){
//            System.out.println("Token: " + tokens[i] + " | Tag: " + tags[i]);
            String tag = tags[i];
            if(tag.equals("NOUN")||tag.equals("PROPN")){
                nouns.add(tokens[i].toLowerCase());
            }
            else if (tag.startsWith("V")){
                verbs.add(tokens[i].toLowerCase());
            }
            else if (tag.startsWith("A")){
                adjectives.add(tokens[i].toLowerCase());
            }
        }

        keywords.addAll(nouns);
        keywords.addAll(verbs);
        keywords.addAll(adjectives);


//        System.out.println("Keywords"+keywords);

        return keywords;


    }



}
