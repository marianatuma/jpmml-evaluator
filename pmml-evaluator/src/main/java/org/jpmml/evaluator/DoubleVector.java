/*
 * Copyright (c) 2017 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

abstract
public class DoubleVector extends Vector<Double> {

	abstract
	public double doubleValue(int index);

	abstract
	public double doubleSum();

	abstract
	public double doubleMax();

	abstract
	public double doubleMedian();

	abstract
	public double doublePercentile(int percentile);

	@Override
	public Vector<Double> add(Number value){
		return add(value.doubleValue());
	}

	@Override
	public Vector<Double> add(double coefficient, Number factor){
		return add(coefficient * factor.doubleValue());
	}

	@Override
	public Value<Double> get(int index){
		return new DoubleValue(doubleValue(index));
	}

	@Override
	public Value<Double> sum(){
		return new DoubleValue(doubleSum());
	}

	@Override
	public Value<Double> max(){
		return new DoubleValue(doubleMax());
	}

	@Override
	public Value<Double> median(){
		return new DoubleValue(doubleMedian());
	}
}