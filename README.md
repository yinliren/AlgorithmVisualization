# Java Math Simulation Visualization

**Develop Environment:**<br />
IntelliJ IDEA 2018.2.5 (Ultimate Edition)<br />
JRE: 1.8.0_152-release-1248-b19 x86_64<br />
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o<br />
macOS 10.13.6<br />

## Content <br />
1. Random Money Giving Simulation
2. Monte Carlo Simulation: Value of Pi 

### 1. Random Giving Money Simulation<br />
Original Article: <http://www.decisionsciencenews.com/2017/06/19/counterintuitive-problem-everyone-room-keeps-giving-dollars-random-others-youll-never-guess-happens-next/> <br />

Imagine a room full of 100 people with 100 dollars each. With every tick of the clock, every person with money gives a dollar to one randomly chosen other person. After some time progresses, how will the money be distributed? <br />
<br />
If on quick reflection you thought “more or less equally”, you are not alone. I asked 5 super-smart PhDs this question and they all had the same initial intuition. <br />
<br />
Inequality can arise from seemingly innocuous policies — you need to keep an eye on it.

Before sorting the outcomes, the simulated distribution of money is shown as below:<br />
![Alt Text](https://github.com/yinliren/AlgorithmVisualization/blob/master/src/RandomMoneyGiving/RandomGivingMoney.gif)<br />
<br />
After applying the sorting, the simulated distribution can be seen more clearly: <br />
![Alt Text](https://github.com/yinliren/AlgorithmVisualization/blob/master/src/RandomMoneyGiving/RandomMoneyGiving_Sorted.gif)
<br />
In the above simulation, there's no debt concept. Here's the simulation with debt concept, no matter how much money is left for a person, that person still need to give money in his/her turn. If he/she owns money less than zero, he/she is in debt, and the bar in red will be shown: <br />
![Alt Text](https://github.com/yinliren/AlgorithmVisualization/blob/master/src/RandomMoneyGiving/RandomGivingMoney_withDebt.gif) <br />
<br />
**"The point is not that some people become rich and never lose their top position. This runs infinitely and will contain every possible sequence of good and bad luck for every person. The richest will become the poorest, everyone will experience every rank, and so on. The interesting thing is that this simple simulation arrives at a stationary distribution with a skewed, exponential shape. This is due to the boundary at zero wealth which, we imagine, people don’t consider when they think about the problem quickly."**

### 2. Monte Carlo Simulation: Value of Pi <br />
Assume R is the radius of the circle in a simulation. If a square is perfectly fit the circle outside the circle, the length of the square side is 2R. Then we have: <br />
Area of Square: 2R * 2R = 4R^2 <br />
Area of Circle: Pi * R * R = Pi * R^2 <br />
Area of Circle / Area of Square = Pi / 4 <br />
Then we have Pi = 4 * (Area of Circle) / (Area of Square) <br />
By randomly generate point on the square, if the point is within the circle, the point is in red. Otherwise, the point is in green. <br />
![Alt Text](https://github.com/yinliren/AlgorithmVisualization/blob/master/src/MonteCarloSimulation/MonteCarloSimulation_Pi.gif) <br />
<br />
Number of Red dots: Area of Circle <br />
Number of Green dots: Area of Square <br />
Pi = 4 * (Number of Red dots) / (Number of Green dots) <br />
Without processing UI, more simulations can be done in one time to get a more accurate value: <br />
![Alt Text](https://github.com/yinliren/AlgorithmVisualization/blob/master/src/MonteCarloSimulation/MonteCarloExperiment.gif) <br />
We can see that the simulation is precise enough to estimate the value of Pi. <br />
