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

    plt.style.use("ggplot")
    fig, (ax1, ax2) = plt.subplots(1, 2)

    ax1.scatter(df['alpha'], df['measuredHit'], label='Measured Hit')
    ax1.plot(df['alpha'], df['theoreticalHit'], color='blue', label='Theoretical Hit')
    y = sum(i for i in df['theoreticalHit']) / len(df['theoreticalHit'])
    ax1.plot(df['alpha'], [y for _ in df['theoreticalHit']], color='orange')

    ax2.scatter(df['alpha'], df['measuredMiss'], label='Measured Miss')
    ax2.plot(df['alpha'], df['theoreticalMiss'], color='blue', label='Theoretical Miss')
    y = sum(i for i in df['theoreticalMiss']) / len(df['theoreticalMiss'])
    ax2.plot(df['alpha'], [y for _ in df['theoreticalMiss']], color='orange')

    ax1.set_xlabel('Load Factor α')
    ax2.set_xlabel('Load Factor α')
    ax1.set_ylabel('Average Probes')
    ax2.set_ylabel('Average Probes')

    ax1.set_title('Measured hits')
    ax2.set_title('Measured misses')
    
    ax1.legend()
    ax2.legend()

    plt.show()

def main():
    csv = check_input_file()
    plot_findings(csv)

if __name__ == "__main__":
    main()