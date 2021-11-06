/*
 Copyright 2021 Google LLC

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordComplexityTest {

   @Test
   public void isPasswordComplex_true() {
       assertTrue(PasswordComplexity.isPasswordComplex("Happy12"));
       assertTrue(PasswordComplexity.isPasswordComplex("1SarahL ength"));
       assertTrue(PasswordComplexity.isPasswordComplex("Password12"));
       assertTrue(PasswordComplexity.isPasswordComplex("2PassW@ord1"));
       assertTrue(PasswordComplexity.isPasswordComplex("01Sall#y9"));
   }

   @Test
   public void isPasswordComplex_false() {
       assertFalse(PasswordComplexity.isPasswordComplex("12aB "));
       assertFalse(PasswordComplexity.isPasswordComplex("Ab112"));
       assertFalse(PasswordComplexity.isPasswordComplex("happy"));
       assertFalse(PasswordComplexity.isPasswordComplex("happy_1"));
       assertFalse(PasswordComplexity.isPasswordComplex("p assword12"));
       assertFalse(PasswordComplexity.isPasswordComplex("Sur18"));
       assertFalse(PasswordComplexity.isPasswordComplex(""));
   }
}
