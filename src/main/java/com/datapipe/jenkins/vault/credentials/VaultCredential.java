package com.datapipe.jenkins.vault.credentials;

import javax.annotation.Nonnull;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.cloudbees.plugins.credentials.CredentialsNameProvider;
import com.cloudbees.plugins.credentials.NameWith;
import com.cloudbees.plugins.credentials.common.StandardCredentials;

@NameWith(VaultCredential.NameProvider.class)
public interface VaultCredential extends StandardCredentials {
    Vault authorizeWithVault(Vault vault, VaultConfig config);

    class NameProvider extends CredentialsNameProvider<VaultCredential> {

      @Nonnull
      public String getName(@Nonnull VaultCredential credentials) {
         return credentials.getDescription();
      }
   }
}
