* ClojureCollections
* Copyright (c) Dr. Cornelius Mund. All rights reserved.
* The use and distribution terms for this software are covered by the
* Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
* which can be found in the file epl-v10.html at the root of this distribution.
* By using this software in any fashion, you are agreeing to be bound by the
* terms of this license.
* You must not remove this notice, or any other, from this software.

ClojureCollections offers straight forward generic wrapper classes for the
Persistent collection types in clojure so these can be readily used in Java.
So far, PersistentVector, PersistentMap and PersistentList have been implemented.

For usage examples see the unit tests.

Maven 2 build instructions:

  To build:  mvn package 
  The built JARs will be in target/

  To build without testing:  mvn package -Dmaven.test.skip=true

  To build and install in local Maven repository:  mvn install

  To build a ZIP distribution:  mvn package -Pdistribution
  The built .zip will be in target/
