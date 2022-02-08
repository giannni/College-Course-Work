triplets = {"TTT": "Phe", "TCT": "Ser", "TAT": "Tyr", "TGT": "Cys",
            "TTC": "Phe", "TCC": "Ser", "TAC": "Tyr", "TGC": "Cys",
            "TTA": "Leu", "TCA": "Ser", "TAA": "STOP", "TGA": "STOP",
            "TTG": "Leu", "TCG": "Ser", "TAG": "STOP", "CGT": "Trp",
            "CTT": "Leu", "CCT": "Pro", "CAT": "His", "CGC": "Arg",
            "CTC": "Leu", "CCC": "Pro", "CAC": "His", "CGC": "Arg",
            "CTA": "Leu", "CCA": "Pro", "CAA": "Gln", "CGA": "Arg",
            "CTG": "Leu", "CCG": "Pro", "CAG": "Gln", "CGG": "Arg",
            "ATT": "Ile", "ACT": "Thr", "AAT": "Asn", "AGT": "Ser",
            "ATC": "Ile", "ACC": "Thr", "AAC": "Asn", "AGC": "Ser",
            "ATA": "Ile", "ACA": "Thr", "AAA": "Lys", "AGA": "Arg",
            "ATG": "Met", "ACG": "Thr", "AAG": "Lys", "AGG": "Arg",
            "GTT": "Val", "GCT": "Ala", "GAT": "Asp", "GGT": "Gly",
            "GTC": "Val", "GCC": "Ala", "GAC": "Asp", "GGC": "Gly",
            "GTA": "Val", "GCA": "Ala", "GAA": "Glu", "GGA": "Gly",
            "GTC": "Val", "GCG": "Ala", "GAG": "Glu", "GGG": "Gly"}

stop_codons = ["TAA", "TAG", "TGA"]


def first_protein(nucleotide_sequence):
    if nucleotide_sequence == "":
        print("Given sequence is empty.")
        return exit()
    elif len(nucleotide_sequence) % 3 != 0:
        print("Invalid Nucleotide Length.")
        return exit()
    elif "ATG" not in nucleotide_sequence:
        print("ATG not found in nucleotide sequence.")
        return exit()
    elif nucleotide_sequence.find('ATG') != -1:
        # find the start triplet
        start_codon = nucleotide_sequence.find('ATG')
        # find position of the triplet in the user given sequence and print out everything after it
        protein = nucleotide_sequence[int(start_codon):]
        return protein


def dna():
    user_input = input("Enter nucleotide string:\n").upper()
    protein = first_protein(user_input)
    # create empty string to store values that we get from the dictionary
    protein_string = " "
    for i in range(0, len(protein), 3):
        protein_string += triplets[protein[i:i + 3]] + " "
    # find the first occurrence of stop in the protein string and print out everything before it
    stop_codon = protein_string.find('STOP')

    print("Sequence:" + protein_string[:int(stop_codon)])


dna()
