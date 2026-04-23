"""
This file is for plotting the findings of experiment Hash 1 using the python matplotlib module.
"""
import matplotlib.pyplot as plt 
import pandas as pd
import sys  

def check_input_file():
    if len(sys.argv) < 2:
        print("No CSV file provived")
        sys.exit(1)
    # TODO: Check if the provided file is indeed a CSV file
    return sys.argv[1]

def plot_findings(csv_path: str):
    df = pd.read_csv(csv_path)

    plt.figure(figsize=(10, 6))
    plt.plot(df['alpha'], df['measuredHit'], label='Measured Hit')
    plt.plot(df['alpha'], df['theoreticalHit'], '--', label='Theoretical Hit')

    plt.plot(df['alpha'], df['measuredMiss'], label='Measured Miss')
    plt.plot(df['alpha'], df['theoreticalMiss'], '--', label='Theoretical Miss')

    plt.xlabel('Load Factor α')
    plt.ylabel('Average Probes')
    
    plt.title('Linear Probing')
    plt.grid(True)
    plt.legend()

    plt.show()

def main():
    csv = check_input_file()
    plot_findings(csv)

if __name__ == "__main__":
    main()